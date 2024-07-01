package com.alura.api.forum.hub.domain.reply;

import com.alura.api.forum.hub.domain.course.CategoryCourses;
import com.alura.api.forum.hub.domain.course.Course;
import com.alura.api.forum.hub.domain.topic.Topic;
import com.alura.api.forum.hub.domain.user.User;
import com.alura.api.forum.hub.domain.user.UserCreationDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class ReplyRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private ReplyRepository replyRepository;

    @Test
    @DisplayName("Deveria devolver uma página de respostas por tópico")
    void findByTopicPagination() {
        var user = createUser();
        var course = createCourse();
        var topic = createTopic(user, course);

        for(int i = 0; i < 10; i++) {
            createReply(user, topic);
        }

        testEntityManager.flush();

        Pageable pageable = PageRequest.of(0, 5);
        Page<Reply> repliesPage = replyRepository.findByTopic(topic, pageable);

        assertThat(repliesPage).hasSize(5);
        assertThat(repliesPage.getTotalPages()).isEqualTo(2);
        assertThat(repliesPage.getTotalElements()).isEqualTo(10);
    }

    @Test
    @DisplayName("Deveria devolver uma resposta por tópico(id) e Id da resposta ")
    void findByTopicIdAndIdScenario1() {
        var user = createUser();
        var course = createCourse();
        var topic = createTopic(user, course);
        var replyCreate = createReply(user, topic);

        testEntityManager.flush();

        var reply = replyRepository.findByTopicIdAndId(topic.getId(), replyCreate.getId());

        assertThat(reply).isEqualTo(replyCreate);
    }

    @Test
    void deleteByTopicIdAndId() {
        var user = createUser();
        var course = createCourse();
        var topic = createTopic(user, course);
        var reply = createReply(user, topic);

        testEntityManager.flush();

        replyRepository.deleteByTopicIdAndId(topic.getId(), reply.getId());

        Reply deletedReply = replyRepository.findByTopicIdAndId(topic.getId(), reply.getId());
        assertThat(deletedReply).isNull();
    }

    private <T> T saveEntity(T entity) {
        return testEntityManager.persist(entity);
    }

    private User createUser() {
        User user = dataUser();
        return saveEntity(user);
    }

    private Course createCourse() {
        Course course = dataCourse();
        return saveEntity(course);
    }

    private Topic createTopic(User user, Course course) {
        Topic topic = dataTopics(user, course);
        return saveEntity(topic);
    }

    private Reply createReply(User user, Topic topic) {
        Reply reply = dataReply(user, topic);
        return saveEntity(reply);
    }

    private Topic dataTopics(User user, Course course) {
        return new Topic(
                "Título do Tópico",
                "Mensagem inicial do tópico",
                user,
                course
        );
    }

    private User dataUser() {
        UserCreationDTO userCreationDTO = new UserCreationDTO(
                "John Doe",
                "john.doe@example.com",
                "password123");
        return new User(userCreationDTO);
    }

    private Course dataCourse() {
        return new Course(
                "Curso de Java",
                CategoryCourses.JAVA);
    }

    private Reply dataReply(User user, Topic topic) {
        ReplyCreationDTO replyCreationDTO = new ReplyCreationDTO(
                "Essa é uma mensagem",
                1L,
                1L,
                "solucao aqui");
        return new Reply(replyCreationDTO, user, topic);
    }
}