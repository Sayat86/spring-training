package com.example.sayatspringtraining.video;

import com.example.sayatspringtraining.channel.Channel;
import com.example.sayatspringtraining.view.View;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "videos")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "is_hidden")
    private Boolean isHidden;
    private Integer views;

    @ManyToOne
    @JoinColumn(name = "channel_id")
    private Channel channel;

    @OneToMany(mappedBy = "video")
    private List<View> viewList;
}
