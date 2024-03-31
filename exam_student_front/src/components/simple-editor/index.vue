<template>
  <div style="border: 1px solid #ccc">
    <Toolbar
      style="border-bottom: 1px solid #ccc"
      :editor="editorRef"
      :default-config="toolbarConfig"
      mode="default"
    />
    <Editor
      :model="props.content"
      style="height: 200px; overflow-y: hidden"
      :default-config="editorConfig"
      mode="default"
      @on-created="handleCreated"
      @on-change="handleChange"
    />
  </div>
</template>

<script setup lang="ts">
  import '@wangeditor/editor/dist/css/style.css'; // 引入 css
  import { onBeforeUnmount, onMounted, shallowRef } from 'vue';
  import { Editor, Toolbar } from '@wangeditor/editor-for-vue';
  import { IDomEditor } from '@wangeditor/editor';

  const emit = defineEmits(['editorGetText', 'editorGetHtml']);
  const props = defineProps(['content']);

  // 编辑器实例，必须用 shallowRef
  const editorRef = shallowRef();

  // 模拟 ajax 异步获取内容
  onMounted(() => {});

  const toolbarConfig = {};
  const editorConfig = { placeholder: '请输入内容...' };

  // 组件销毁时，也及时销毁编辑器
  onBeforeUnmount(() => {
    const editor = editorRef.value;
    if (editor == null) return;
    editor.destroy();
  });

  const handleCreated = (editor: any) => {
    editor.setHtml(props.content as string);
    editorRef.value = editor; // 记录 my-editor 实例，重要！
  };
  const handleChange = (editor: IDomEditor) => {
    // TS 语法
    emit('editorGetText', editor.getText());
    emit('editorGetHtml', editor.getHtml());
  };
</script>
