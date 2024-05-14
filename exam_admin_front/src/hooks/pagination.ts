import { ref } from 'vue';
import SimplePage from '@/types/model/po/SimplePage';

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
