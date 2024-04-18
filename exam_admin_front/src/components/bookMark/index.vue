<template>
  <!--这里有锚点-->
  <div :id="anchorId" style="position: relative; top: -100px" />
  <div class="flag">{{ number }}</div>
</template>

<script lang="ts" setup>
  // anchorId 锚点Id
  defineProps(['number', 'anchorId']);
</script>

<style>
  .flag {
    position: relative;
    box-sizing: content-box;
    width: 30px;
    height: 30px;
    padding-top: 5px;
    color: white;
    font-size: 11px;
    letter-spacing: 0.2em;
    text-align: center;
    text-transform: uppercase;
    background: #5794f7;
  }

  .flag:after {
    position: absolute;
    bottom: 0;
    left: 0;
    width: 0;
    height: 0;
    border-right: 15px solid transparent;
    border-bottom: 6px solid #eee;
    border-left: 15px solid transparent;
    content: '';
  }

  /* E 垂直方向的标签 */
</style>
