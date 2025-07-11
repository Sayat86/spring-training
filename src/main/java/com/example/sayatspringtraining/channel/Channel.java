package com.example.sayatspringtraining.channel;

import com.example.sayatspringtraining.user.User;
import com.example.sayatspringtraining.video.Video;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "channels")
public class Channel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private String country;
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "channel")
    private List<Video> videos;

    @ManyToMany(mappedBy = "subscribedChannels")
    private List<User> subscribers = new ArrayList<>();
}
