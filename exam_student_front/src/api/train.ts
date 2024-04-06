import axios from 'axios';
import { StartTrainDTO } from '@/types/model/dto/StartTrainDTO';
import { TrainRecordQuQuery } from '@/types/model/query/TrainRecordQuQuery';
import { TrainRecordQuVO } from '@/types/model/vo/TrainRecordQuVO';
import { TrainRecord } from '@/types/model/po/TrainRecord';
import { Train } from '@/types/model/po/Train';
import { TrainQuery } from '@/types/model/query/TrainQuery';

/**
 * 开始训练
 */
// eslint-disable-next-line import/prefer-default-export
export function startTrain(startTrainDTO: StartTrainDTO) {
  return axios.post<string>('/api/studentTrain/startTrain', startTrainDTO);
}

// 根据Id获取训练记录
export function getTrainRecordById(trainId: string) {
  return axios.post<string[]>('/api/studentTrain/getTrainRecordById', trainId, {
    headers: {
      'Content-Type': 'text/plain',
    },
  });
}

// 根据sort+获取训练记录Id 获取题目信息
export function getTrainRecordQu(trainRecordQuQuery: TrainRecordQuQuery) {
  return axios.post<TrainRecordQuVO>(
    '/api/studentTrain/getTrainRecordQu',
    trainRecordQuQuery
  );
}

// 更新作答记录
export function updateTrainRecord(trainRecord: TrainRecord) {
  return axios.post<TrainRecordQuVO>(
    '/api/studentTrain/updateTrainRecord',
    trainRecord
  );
}

// 更新训练内容
export function stopTrain(trainId: string) {
  return axios.post<boolean>('/api/studentTrain/stopTrain', trainId, {
    headers: {
      'Content-Type': 'text/plain',
    },
  });
}

// 通过Id获取训练记录
export function getTrainById(trainId: string) {
  return axios.post<Train>('/api/studentTrain/getTrainById', trainId, {
    headers: {
      'Content-Type': 'text/plain',
    },
  });
}

// 条件查询训练记录
export function getTrain(trainQuery: TrainQuery) {
  return axios.post<Train[]>('/api/studentTrain/getTrain', trainQuery, {});
}
