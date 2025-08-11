package com.example.sayatspringtraining.view.dto;

import com.example.sayatspringtraining.video.dto.VideoForViewDto;
import com.example.sayatspringtraining.view.View;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ViewMapper {

    public ViewResponseDto toResponse(View view) {
        ViewResponseDto viewResponseDto = new ViewResponseDto();
        VideoForViewDto videoForViewDto = new VideoForViewDto();

        videoForViewDto.setId(view.getVideo().getId());
        videoForViewDto.setName(view.getVideo().getName());
        videoForViewDto.setDescription(view.getVideo().getDescription());
        videoForViewDto.setView(view.getVideo().getViews());
        videoForViewDto.setChannel(view.getVideo().getChannel().getName());


        viewResponseDto.setId(view.getId());
        viewResponseDto.setCreatedAt(view.getCreatedAt());
        viewResponseDto.setUpdatedAt(view.getUpdatedAt());
        viewResponseDto.setVideo(videoForViewDto);
        return viewResponseDto;
    }

    public List<ViewResponseDto> toResponse(List<View> views) {
        return views.stream()
                .map(this::toResponse)
                .toList();
    }
}
