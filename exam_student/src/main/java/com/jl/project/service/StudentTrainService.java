package com.jl.project.service;

import com.jl.project.entity.dto.StartTrainDTO;
import com.jl.project.entity.po.Repo;
import com.jl.project.entity.po.Train;
import com.jl.project.entity.po.TrainRecord;
import com.jl.project.entity.query.RepoQuery;
import com.jl.project.entity.query.TrainQuery;
import com.jl.project.entity.query.TrainRecordQuQuery;
import com.jl.project.entity.vo.TrainRecordQuVO;

import java.util.List;
import java.util.Map;

public interface StudentTrainService {
    public List<Repo> getRepoList(RepoQuery repoQuery);

    Map<Integer, Long> getQuTypeClassifyByRepoId(String repoId);

    String startTrain(StartTrainDTO startTrainDTO);

    Integer getTrainRecordById(String trainId);

    TrainRecordQuVO getTrainRecordQu(TrainRecordQuQuery trainRecordQuQuery);

    Boolean updateTrainRecord(TrainRecord trainRecord);

    Boolean stopTrain(String trainId);

    Train getTrainById(String trainId);

    List<Train> getTrain(TrainQuery trainQuery);
}
