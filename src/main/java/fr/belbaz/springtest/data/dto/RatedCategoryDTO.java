package fr.belbaz.springtest.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RatedCategoryDTO
{
    private String category;
    private float  average;
}
