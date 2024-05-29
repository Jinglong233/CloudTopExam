<template>
  <div style="border: 1px solid #ccc">
    <Toolbar
      style="border-bottom: 1px solid #ccc"
      :editor="editorRef"
      :default-config="toolbarConfig"
      mode="default"
    />
    <Editor
      v-model="valueHtml"
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
  import { onBeforeUnmount, onMounted, ref, shallowRef } from 'vue';
  import { Editor, Toolbar } from '@wangeditor/editor-for-vue';
  import { IDomEditor, IEditorConfig } from '@wangeditor/editor';
  import { Message } from '@arco-design/web-vue';
  import axios from 'axios';
  import { useUserStore } from '@/store';

  const userStore = useUserStore();
  const emit = defineEmits([
    'editorGetText',
    'editorGetHtml',
    'addDeletePicture',
    'addInsertPicture',
  ]);
  const props = defineProps(['content', 'contentConfirmChange']);

  // 编辑器实例，必须用 shallowRef
  const editorRef = shallowRef();

  const valueHtml = ref(props.content);

  // 模拟 ajax 异步获取内容
  onMounted(() => {});

  const toolbarConfig = {};

  // 自定义图片上传方法
  const uploadImg = (file: File, insertFn: any) => {
    const imgData = new FormData();
    imgData.append('file', file);
    // 调用上传图片接口，上传图片
    axios
      .post('/api/oss/upload/image', imgData)
      .then((res: any) => {
        if (res.code === 200 && res.status === 'success') {
          // 插入后端返回的url
          insertFn(res.data);
          Message.success({
            content: '上传成功',
          });
        } else {
          Message.error({
            content: '上传失败,请重新上传',
          });
        }
      })
      .catch((error) => {
        Message.error({
          content: '上传失败,请重新上传',
        });
      });
  };

  // 未编辑前编辑器图片集合
  let oldList: string[] = [];
  // 真正插入的图片集合
  const realInsertList: string[] = [];
  // 插入的图片集合(这个插入集合是混合了oldList的)
  let insertList: string[] = [];
  // 编辑完成时的图片集合
  let finishList: string[] = [];
  // 需要删除的图片集合
  let deleteList: string[] = [];

  const editorConfig: Partial<IEditorConfig> = {
    placeholder: '请输入内容...',
    // 上传图片配置
    MENU_CONF: {
      uploadImage: {
        headers: {
          Authorization: userStore.token,
        },

        // 最大文件1M
        maxFileSize: 1 * 1024 * 1024,
        // 超时时间，默认为 10 秒
        timeout: 5 * 1000, // 5 秒
        // 自定义上传
        customUpload: uploadImg,
      },
      // 收集上传或插入的图片
      insertImage: {
        onInsertedImage(imageNode: any | null) {
          // TS 语法
          if (imageNode == null) return;
          const { src, alt, url, href } = imageNode;
          insertList.push(src);
          realInsertList.push(src);
        },
      },
    },
  };

  // 组件销毁时，也及时销毁编辑器
  onBeforeUnmount(() => {
    const editor = editorRef.value;
    finishList = editor
      .getElemsByType('image')
      .map((obj: any) => obj.src)
      .filter((value: any) => value !== undefined);
    // 确认内容改变了才能确认更改图片的集合
    // 判断条件中获取的是需要删除图片的列表
    if (props.contentConfirmChange) {
      deleteList = insertList.filter((x: string) => !finishList.includes(x));
    } else {
      deleteList = insertList.filter((x: string) => !oldList.includes(x));
    }
    // 触发添加 需要的删除图片和插入图片
    emit('addDeletePicture', deleteList);
    emit('addInsertPicture', realInsertList);

    if (editor == null) return;
    editor.destroy();
  });

  const handleCreated = (editor: any) => {
    editor.setHtml(props.content as string);
    editorRef.value = editor; // 记录 my-editor 实例，重要！
    oldList = editor
      .getElemsByType('image')
      .map((obj: any) => obj.src)
      .filter((value: any) => value !== undefined);
    // 注意：这个插入列表不是是真正新插入的图片的集合。真正插入的列表需要重新定义
    // 创建的时候也需要将原有的图片集合放到插入列表中
    insertList = editor
      .getElemsByType('image')
      .map((obj: any) => obj.src)
      .filter((value: any) => value !== undefined);
  };
  const handleChange = (editor: IDomEditor) => {
    // TS 语法
    emit('editorGetText', editor.getText());
    emit('editorGetHtml', editor.getHtml());
  };
</script>
