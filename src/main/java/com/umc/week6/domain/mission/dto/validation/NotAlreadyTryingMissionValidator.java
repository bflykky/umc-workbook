package com.umc.week6.domain.mission.dto.validation;

import com.umc.week6.domain.mission.repository.TryingMissionRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@RequiredArgsConstructor
@Component
public class NotAlreadyTryingMissionValidator implements ConstraintValidator<NotAlreadyTryingMission, Object> {
    private final TryingMissionRepository tryingMissionRepository;
    private String memberIdField;
    private String missionIdField;


    @Override
    public void initialize(NotAlreadyTryingMission constraintAnnotation) {
        this.memberIdField = constraintAnnotation.memberIdField();
        this.missionIdField = constraintAnnotation.missionIdField();
    }


    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        try {
            Long memberId = getFieldValue(value, memberIdField);
            Long missionId = getFieldValue(value, missionIdField);

            if (memberId == null || missionId == null) {
                return true; // null인 경우에는 다른 Valid 어노테이션이 처리하도록 넘긴다.
            }

            return !tryingMissionRepository.existsByMemberIdAndMissionId(memberId, missionId);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private Long getFieldValue(Object obj, String fieldName) throws NoSuchFieldException, IllegalAccessException {
        Class<?> currentClass = obj.getClass();
        while (currentClass != null) {
            try {
                Field field = currentClass.getDeclaredField(fieldName);
                field.setAccessible(true);

                return (Long) field.get(obj);
            } catch (NoSuchFieldException e) {
                // 상위 클래스 필드 탐색을 위해 클래스 이동
                currentClass = currentClass.getSuperclass();
            }
        }

        throw new NoSuchFieldException(String.format("%s 필드를 주어진 클래스에서 찾을 수 없습니다.", fieldName));
    }
}
