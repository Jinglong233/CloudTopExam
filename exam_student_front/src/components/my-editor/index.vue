<template>
  <div style="border: 1px solid #ccc">
    <Toolbar
      style="border-bottom: 1px solid #ccc"
      :editor="editorRef"
      :default-config="toolbarConfig"
      :mode="mode"
    />
    <Editor
      v-model="valueHtml"
      style="height: 400px; overflow-y: hidden"
      :default-config="editorConfig"
      :mode="mode"
      @on-created="handleCreated"
      @on-change="handleChange"
    />
  </div>
</template>

<script setup lang="ts">
  import { onBeforeUnmount, onMounted, ref, shallowRef } from 'vue';
  import { useRouter } from 'vue-router';
  import '@wangeditor/editor/dist/css/style.css'; // 引入 css
  import { Editor, Toolbar } from '@wangeditor/editor-for-vue';
  import type { IToolbarConfig } from '@wangeditor/core';
  import { Boot, IDomEditor, IEditorConfig } from '@wangeditor/editor';
  import formulaModule from '@wangeditor/plugin-formula';

  // 注册。要在创建编辑器之前注册，且只能注册一次，不可重复注册。
  if (Boot.plugins.length < 13) {
    Boot.registerModule(formulaModule);
  }

  const router = useRouter();
  const editorRef = shallowRef();
  const mode = 'default';

  const emit = defineEmits(['editorGetText', 'editorGetHtml', 'editorDestroy']);

  // 接收父组件的传值(在每次打开编辑框的时候，将输入框中的数据传进去)
  const props = defineProps({
    editorText: String,
    html: String,
    isReadOnly: Boolean,
  });

  const editorConfig: Partial<IEditorConfig> = {
    placeholder: '请输入内容...',
    // 选中公式时的悬浮菜单
    hoverbarKeys: {
      formula: {
        menuKeys: ['editFormula'], // “编辑公式”菜单
      },
    },
    readOnly: props.isReadOnly,
    MENU_CONF: {},
  };

  const valueHtml = ref(props.editorText);

  const handleChange = (editor: IDomEditor) => {
    // TS 语法
    emit('editorGetText', editor.getText());
    emit('editorGetHtml', editor.getHtml());
  };

  // 工具栏配置
  const toolbarConfig: Partial<IToolbarConfig> = {
    // 用于去掉不需要的工具栏配置
    excludeKeys: [
      'fullScreen', // 去掉全屏功能
      'group-video', // 去掉视频
      'emotion', // 去掉表情
      'insertLink', // 去掉插入链接
      'todo', // 去掉待办
    ],
    insertKeys: {
      index: 0,
      keys: [
        'insertFormula', // “插入公式”菜单
        'editFormula', // “编辑公式”菜单
      ],
    },
  };

  onMounted(() => {
    if (props.isReadOnly === true) {
      toolbarConfig.toolbarKeys = [];
      toolbarConfig.insertKeys = {} as any;
    }
  });

  const handleCreated = (editor: any) => {
    editor.setHtml(props.editorText as string);
    editorRef.value = editor; // 记录 my-editor 实例，重要！
  };
  onBeforeUnmount(() => {
    const editor = editorRef.value;
    if (editor == null) return;
    editor.destroy();
  });
</script>
