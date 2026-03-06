package com.portfolio.portfolio_backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "skills")
public class Skill {

    @Id
    private String id;
    
    private String name;
    
    // We will store the Material Icon name as a string (e.g. 'flutter_dash')
    // The Flutter app will need to reconstruct the IconData from this string
    private String iconName;
}
