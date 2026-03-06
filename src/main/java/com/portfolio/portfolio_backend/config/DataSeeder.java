package com.portfolio.portfolio_backend.config;

import com.portfolio.portfolio_backend.model.Profile;
import com.portfolio.portfolio_backend.model.Project;
import com.portfolio.portfolio_backend.model.Skill;
import com.portfolio.portfolio_backend.repository.ProfileRepository;
import com.portfolio.portfolio_backend.repository.ProjectRepository;
import com.portfolio.portfolio_backend.repository.SkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class DataSeeder {

    @Bean
    public CommandLineRunner initData(ProfileRepository profileRepo,
                                      SkillRepository skillRepo,
                                      ProjectRepository projectRepo) {
        return args -> {
            // Seed Profile
            if (profileRepo.count() == 0) {
                Profile profile = Profile.builder()
                        .name("Yogesh Ghule")
                        .title("Hi, I'm Yogesh Ghule")
                        .subtitle("Flutter Developer | Backend Developer")
                        .description("I build web applications and backend systems using Flutter, Spring Boot and MongoDB. Focused on creating efficient, scalable solutions.")
                        .imageUrl("https://lh3.googleusercontent.com/aida-public/AB6AXuAKPYzSajCVOtcN-ry4el2TGSIp1eSc4WO4AZter8ZbgbZixtbANYvagEiKb0nJIZhcCoGDn5sdbXfP7UXmOn8N2fbbg_z4M6fS1BUuLlAxZryb2N_q1LbxEH4NDNZ8feiq_JSEV0Os2LreUkEG290phrnfe3DhcZ_TAgpkSFVDUnecZvXNbGMEP4LN_w171Nzc4b9yubK_in-MBDs2i2wP7a1zalQ4E076c67nzTlPccKt0OrnUsLNT6MTpQl8Din7Lwv27at_Q5cr")
                        .email("hello@yogeshghule.com")
                        .githubUrl("https://github.com/yogesh-ghule")
                        .githubUsername("/yogesh-ghule")
                        .linkedinUrl("https://linkedin.com/in/yogesh-ghule")
                        .linkedinUsername("in/yogesh-ghule")
                        .aboutBio("I am a dedicated developer passionate about modern web technologies and building scalable applications. With expertise in both frontend and backend development, I focus on creating seamless user experiences and robust server-side architectures. My journey in tech is driven by curiosity and the desire to solve complex problems through clean, maintainable code.")
                        .stats(Arrays.asList("2+ Years Experience", "10+ Projects Completed", "5+ Technologies Mastered"))
                        .experience(Arrays.asList(
                                Map.of("title", "Full Stack Developer", "company", "Freelance", "period", "2023 - Present", "description", "Building custom web and mobile applications for clients using Flutter, Spring Boot, and modern web frameworks."),
                                Map.of("title", "Frontend Developer Intern", "company", "Tech Solutions Inc.", "period", "2022 - 2023", "description", "Assisted in developing responsive web interfaces and optimizing user experiences for enterprise clients.")
                        ))
                        .education(Arrays.asList(
                                Map.of("title", "Bachelor of Computer Applications (BCA)", "company", "University Name", "period", "2021 - 2024", "description", "Software Engineering, Database Management, and Data Structures.")
                        ))
                        .build();
                profileRepo.save(profile);
            }

            // Seed Skills
            if (skillRepo.count() == 0) {
                List<Skill> skills = Arrays.asList(
                        Skill.builder().name("Flutter").iconName("flutter_dash").build(),
                        Skill.builder().name("Spring Boot").iconName("settings_applications").build(),
                        Skill.builder().name("MongoDB").iconName("storage").build(),
                        Skill.builder().name("Python").iconName("terminal").build(),
                        Skill.builder().name("REST API").iconName("api").build(),
                        Skill.builder().name("Git").iconName("account_tree").build()
                );
                skillRepo.saveAll(skills);
            }

            // Seed Projects
            if (projectRepo.count() == 0) {
                List<Project> projects = Arrays.asList(
                        Project.builder()
                                .title("Smart Farmer Management System")
                                .description("An end-to-end solution for farmers to manage crops, track expenses, and get real-time weather insights using Flutter and Spring Boot.")
                                .imageUrl("https://lh3.googleusercontent.com/aida-public/AB6AXuAX6oZ27Hdc11Hrf90JxpUytKdtdxrEDPJOf_UdtLLt5MVZ_fBX5mbvldACmfxlW703xmdwS41NaAK76X9DXh7mY6q36-z8D9-u8FRKl1JEFb_MGSKeyByyIUDhdejvOlgQIuck8ZSAKCF7869oY_O7bQ3QKA30F7UZ6_6_uYcSkjlSDA48PQQhpJfkWGDRWSYOcD_b4QUpiLwU6FThu-UynqRtUrjU1UXkUAJ-G_9xkeLH-C3t4jDVF5ic-DDWEoskSdaqQ-Seuvfr")
                                .tags(Arrays.asList("Flutter", "MongoDB"))
                                .build(),
                        Project.builder()
                                .title("Flutter Login System")
                                .description("A secure, reusable authentication module featuring JWT integration, biometric login, and animated UI transitions.")
                                .imageUrl("https://lh3.googleusercontent.com/aida-public/AB6AXuCH8eeu97Pn_w7Sv02BA0pE_Hq9EN-MrXZ2wE3vvHETvk9HKCDmJaMheC3WVKTqakWQX_stF3e7A2QCNCfgoObay4LymQFVBqw6ORgHBHwn_1BYC0JdLnrKs9HMcZZZwnZ2Kqmbp7X5VlhaGp50BgJJZhbz82kjcNPu5ExI_q9z9BGF8qy42b8NswxyQ6X_k7YOYwCi5sYQtZUuE0AAZMsG-iyxCXvVhlyA5SsFY9s2zGrDxbs_i3_MO_sNjlQ271OJNsKU88Nt1-_f")
                                .tags(Arrays.asList("Dart", "Firebase"))
                                .build(),
                        Project.builder()
                                .title("Developer Portfolio Website")
                                .description("A high-performance personal portfolio built with modern web standards, optimized for SEO and lightning-fast loading speeds.")
                                .imageUrl("https://lh3.googleusercontent.com/aida-public/AB6AXuDDIeplngrL7RBVp6IJAUgovVE-2TRrF8hunL8PstJEBuovcL8KwoxkDwPSA0nK-VWsdYD2z5KoHw1Xl_qPF4Ga9M16qoX9Qi7LZTWJD80pItFFEUwY8fiVNI4uo_OSTcYlwh1Wv0vWHDGm9QAacHp4PXUZNPDvt3Ph0rhfRp7EwiahywuiyMjGfpb-qG-mEGaymYqvpZaLtutZFoP6Yfl2ijUp2Lx9xZQHegHtstqwf6nYezNcJWHONkCW0bKA6Nd67a_xAFK3lq1E")
                                .tags(Arrays.asList("HTML/Tailwind", "JS"))
                                .build()
                );
                projectRepo.saveAll(projects);
            }
        };
    }
}
