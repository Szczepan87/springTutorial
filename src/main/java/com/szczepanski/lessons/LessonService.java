package com.szczepanski.lessons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    public List<Lesson> getAllLessons(String id) {
        List<Lesson> lessons = new ArrayList<>();
        lessonRepository.findByCourseId(id).forEach(lessons::add);
        return lessons;
    }

    public Lesson getLesson(String id) {
        return lessonRepository.findById(id).get();
    }

    public void addLesson(Lesson lesson) {
        lessonRepository.save(lesson);
    }

    public void updateLesson(String id, Lesson lesson) {
        if (lessonRepository.existsById(id)) {
            lessonRepository.save(lesson);
        }
    }

    public void deleteLesson(String id) {
        lessonRepository.deleteById(id);
    }
}
