import axios from 'axios';

export function ossUpload(file: File) {
  return axios.post('/api/oss/upload/image', file);
}

export function deleteImage(url: string) {
  return axios.post<boolean>('/api/oss/delete/image', url, {
    headers: {
      'Content-Type': 'text/plain',
    },
  });
}

export function deleteBatchImage(urlList: string[]) {
  return axios.post<boolean>(
    '/api/oss/deleteBatch/image',
    JSON.stringify(urlList),
    {
      headers: {
        'Content-Type': 'application/json', // 设置请求头为 JSON 格式
      },
    }
  );
}
