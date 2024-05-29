import { ref } from 'vue';
import SimplePage from '@/types/model/po/SimplePage';

// @ts-ignore
export default function usePagination(initValue = new SimplePage()) {
  const pagination = ref(initValue);
  const setPagination = (value: SimplePage) => {
    pagination.value = value;
  };

  return {
    pagination,
    setPagination,
  };
}
