<template>
  <a-spin :loading="loading" style="width: 100%">
    <a-grid :cols="2" :col-gap="12" :row-gap="16" class="grid-demo-grid">
      <a-card :bordered="false">
        <template #extra>
          <a-select
            :style="{ width: '160px' }"
            placeholder="Select"
            :trigger-props="{ autoFitPopupMinWidth: true }"
          >
            <a-option>Beijing-Beijing-Beijing</a-option>
            <a-option>Shanghai</a-option>
            <a-option>Guangzhou</a-option>
            <a-option disabled>Disabled</a-option>
          </a-select>
        </template>
        <a-grid-item class="demo-item"
          ><a-table :columns="columns" :data="data"
        /></a-grid-item>
      </a-card>

      <a-card :bordered="false">
        <template #extra>
          <a-select
            :style="{ width: '160px' }"
            placeholder="Select"
            :trigger-props="{ autoFitPopupMinWidth: true }"
          >
            <a-option>Beijing-Beijing-Beijing</a-option>
            <a-option>Shanghai</a-option>
            <a-option>Guangzhou</a-option>
            <a-option disabled>Disabled</a-option>
          </a-select>
        </template>
        <a-grid-item class="demo-item"
          ><a-table :columns="columns" :data="data"
        /></a-grid-item>
      </a-card>
    </a-grid>
  </a-spin>
</template>

<script lang="ts" setup>
  import useLoading from '@/hooks/loading';
  import useThemes from '@/hooks/themes';
  import { reactive } from 'vue';

  const { loading, setLoading } = useLoading(true);
  const { isDark } = useThemes();

  const columns = [
    {
      title: 'Name',
      dataIndex: 'name',
    },
    {
      title: 'Salary',
      dataIndex: 'salary',
    },
    {
      title: 'Address',
      dataIndex: 'address',
    },
    {
      title: 'Email',
      dataIndex: 'email',
    },
  ];
  const data = reactive([
    {
      key: '1',
      name: 'Jane Doe',
      salary: 23000,
      address: '32 Park Road, London',
      email: 'jane.doe@example.com',
    },
    {
      key: '2',
      name: 'Alisa Ross',
      salary: 25000,
      address: '35 Park Road, London',
      email: 'alisa.ross@example.com',
    },
    {
      key: '3',
      name: 'Kevin Sandra',
      salary: 22000,
      address: '31 Park Road, London',
      email: 'kevin.sandra@example.com',
    },
    {
      key: '4',
      name: 'Ed Hellen',
      salary: 17000,
      address: '42 Park Road, London',
      email: 'ed.hellen@example.com',
    },
    {
      key: '5',
      name: 'William Smith',
      salary: 27000,
      address: '62 Park Road, London',
      email: 'william.smith@example.com',
    },
  ]);

  const fetchData = async () => {
    setLoading(true);
    try {
      // you can report use errorHandler or other
    } catch (err) {
      // you can report use errorHandler or other
    } finally {
      setLoading(false);
    }
  };
  fetchData();
</script>

<style scoped lang="less">
  :deep(.arco-statistic) {
    .arco-statistic-title {
      color: rgb(var(--gray-10));
      font-weight: bold;
    }
    .arco-statistic-value {
      display: flex;
      align-items: center;
    }
  }
  .statistic-prefix {
    display: inline-block;
    width: 32px;
    height: 32px;
    margin-right: 8px;
    color: var(--color-white);
    font-size: 16px;
    line-height: 32px;
    text-align: center;
    vertical-align: middle;
    border-radius: 6px;
  }
</style>
