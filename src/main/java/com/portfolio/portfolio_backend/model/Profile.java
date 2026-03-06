package com.portfolio.portfolio_backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "profiles")
public class Profile {

    @Id
    private String id;

    private String name;
    private String title;
    private String subtitle;
    private String description;
    private String imageUrl;
    private String email;
    private String githubUrl;
    private String githubUsername;
    private String linkedinUrl;
    private String linkedinUsername;
    private String aboutBio;
    
    private List<String> stats;
    private List<Map<String, String>> experience;
    private List<Map<String, String>> education;
}
