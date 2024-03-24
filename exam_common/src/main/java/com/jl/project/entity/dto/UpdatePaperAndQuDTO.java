package com.jl.project.entity.dto;

public class UpdatePaperAndQuDTO {
    private AddPaperDTO addPaperDTO;
    private String id;

    public AddPaperDTO getAddPaperDTO() {
        return addPaperDTO;
    }

    public void setAddPaperDTO(AddPaperDTO addPaperDTO) {
        this.addPaperDTO = addPaperDTO;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
