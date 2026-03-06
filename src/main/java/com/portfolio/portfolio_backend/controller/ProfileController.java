package com.portfolio.portfolio_backend.controller;

import com.portfolio.portfolio_backend.model.Profile;
import com.portfolio.portfolio_backend.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profile")
@RequiredArgsConstructor
@CrossOrigin(origins = "*") // Allows Flutter web app to access this API
public class ProfileController {

    private final ProfileRepository profileRepository;

    @GetMapping
    public ResponseEntity<Profile> getProfile() {
        List<Profile> profiles = profileRepository.findAll();
        if (profiles.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        // Assuming we only have one main profile
        return ResponseEntity.ok(profiles.get(0));
    }

    @PostMapping
    public ResponseEntity<Profile> createProfile(@RequestBody Profile profile) {
        // We ensure only one profile exists for simplicity
        profileRepository.deleteAll();
        Profile savedProfile = profileRepository.save(profile);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProfile);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profile> updateProfile(@PathVariable String id, @RequestBody Profile profileDetails) {
        return profileRepository.findById(id)
                .map(existingProfile -> {
                    // Update all fields
                    existingProfile.setName(profileDetails.getName());
                    existingProfile.setTitle(profileDetails.getTitle());
                    existingProfile.setSubtitle(profileDetails.getSubtitle());
                    existingProfile.setDescription(profileDetails.getDescription());
                    existingProfile.setImageUrl(profileDetails.getImageUrl());
                    existingProfile.setEmail(profileDetails.getEmail());
                    existingProfile.setGithubUrl(profileDetails.getGithubUrl());
                    existingProfile.setGithubUsername(profileDetails.getGithubUsername());
                    existingProfile.setLinkedinUrl(profileDetails.getLinkedinUrl());
                    existingProfile.setLinkedinUsername(profileDetails.getLinkedinUsername());
                    existingProfile.setAboutBio(profileDetails.getAboutBio());
                    existingProfile.setStats(profileDetails.getStats());
                    existingProfile.setExperience(profileDetails.getExperience());
                    existingProfile.setEducation(profileDetails.getEducation());

                    return ResponseEntity.ok(profileRepository.save(existingProfile));
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
