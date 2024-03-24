<template>
  <div class="list-wrap">
    <!--题库列表-->
    <a-grid :cols="4" :col-gap="12" :row-gap="16" class="grid-demo-grid">
      <a-grid-item class="demo-item">
        <div class="card-wrap empty-wrap" style="height: 250px">
          <a-card :bordered="false" hoverable>
            <a-result
              :status="null"
              :title="$t('cardList.content.action')"
              @click="addRepo"
            >
              <template #icon>
                <icon-plus style="font-size: 20px" />
              </template>
            </a-result>
          </a-card>
        </div>
      </a-grid-item>
      <a-grid-item v-for="repo in repoList" :key="repo.id" class="demo-item">
        <CardWrap
          :repo="repo"
          :loading="loading"
          :title="repo.title"
          :description="repo.createTime"
          :open-txt="$t('cardList.content.edit')"
          :close-txt="$t('cardList.content.delete')"
          :tag-text="repo.deptText"
          @reload-repo-list="reloadRepoList"
        >
          <a-descriptions
            style="margin-top: 16px"
            layout="inline-horizontal"
            table-layout="fixed"
            :column="2"
          >
            <a-descriptions-item>
              <template #label> 总题数 </template>
              {{ repo.totalCount }}
            </a-descriptions-item>
            <a-descriptions-item>
              <template #label> 客观题 </template>
              {{ repo.subCount }}
            </a-descriptions-item>
            <a-descriptions-item>
              <template #label> 主观题 </template>
              {{ repo.objCount }}
            </a-descriptions-item>
            <a-descriptions-item>
              <template #label> 是否用于训练 </template>
              <a-tag v-if="repo.isTrain === 1" size="small" color="green">
                <template #icon>
                  <icon-check-circle-fill />
                </template>
              </a-tag>
              <a-tag v-if="repo.isTrain === 0" size="small" color="red">
                <template #icon>
                  <icon-close-circle-fill />
                </template>
              </a-tag>
            </a-descriptions-item>
            <a-descriptions-item>
              <template #label> 是否用于考试 </template>
              <a-tag v-if="repo.isExam === 1" size="small" color="green">
                <template #icon>
                  <icon-check-circle-fill />
                </template>
              </a-tag>
              <a-tag v-if="repo.isExam === 0" size="small" color="red">
                <template #icon>
                  <icon-close-circle-fill />
                </template>
              </a-tag>
            </a-descriptions-item>
          </a-descriptions>
          <a-typography-paragraph
            style="margin-top: 16px"
            :ellipsis="{
              rows: 2,
              showTooltip: true,
            }"
          >
            {{ `备注：${repo.remark}` }}
          </a-typography-paragraph>
          <template #skeleton>
            <a-skeleton :animation="true">
              <a-skeleton-line
                :widths="['50%', '50%', '100%', '40%']"
                :rows="4"
              />
              <a-skeleton-line :widths="['40%']" :rows="1" />
            </a-skeleton>
          </template>
        </CardWrap>
      </a-grid-item>
    </a-grid>
  </div>
</template>

<script lang="ts" setup>
  import { useRouter } from 'vue-router';

  import CardWrap from './card-wrap.vue';

  const props = defineProps(['repoList', 'loading']);
  const router = useRouter();

  // 通知父组件刷新
  const emit = defineEmits(['reloadRepoList']);
  /**
   * 创建题库
   */
  const addRepo = () => {
    router.push({
      path: '/repo/add-repo',
    });
    console.log('创建题库');
  };

  /**
   * 通知父组件刷新
   */
  const reloadRepoList = () => {
    // 通知父组件刷新
    emit('reloadRepoList');
  };
</script>

<style scoped lang="less">
  .card-wrap {
    height: 100%;
    border: 1px solid var(--color-neutral-3);
    transition: all 0.3s;

    &:hover {
      transform: translateY(-4px);
    }

    :deep(.arco-card-meta-description) {
      color: rgb(var(--gray-6));

      .arco-descriptions-item-label-inline {
        color: rgb(var(--gray-6));
        font-weight: normal;
        font-size: 12px;
      }

      .arco-descriptions-item-value-inline {
        color: rgb(var(--gray-8));
      }
    }
  }

  .empty-wrap {
    height: 200px;
    border-radius: 4px;

    :deep(.arco-card) {
      display: flex;
      align-items: center;
      justify-content: center;
      height: 100%;
      border-radius: 4px;

      .arco-result-title {
        color: rgb(var(--gray-6));
      }
    }
  }
</style>
