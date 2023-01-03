package org.prgrms.japexample.lecture.repository.domain.customer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class CustomerServiceTest {
    @Nested
    @DisplayName("when create")
    class WhenCreate{
        //todo: customer 생성 정상 케이스
        @Test
        @DisplayName("생성 성공")
        public void customerSuccess() throws Exception {
            //given

            //when

            //then
        }
        //todo: customer 잘못된 생성 : 성 혹은 이름이 공백
        @Test
        @DisplayName("생성 실패 : 성이나 이름이 공백임")
        public void failureWithBlank() throws Exception {
            //given

            //when

            //then
        }
        //todo: customer 잘못된 생성 : 성 혹은 이름이 제한된 길이를 넘김
        @Test
        @DisplayName("생성 실패 : 성이나 이름이 제한된 길이보다 긺")
        public void failureBiggerThenMaxLength() throws Exception {
            //given

            //when

            //then
        }
        //todo: customer 잘못된 생성 : 성 혹은 이름에 특수 문자가 들어감
        @Test
        @DisplayName("생성 실패 : 성이나 이름이 특수 문자를 가지고 있음")
        public void failureWithSpacialCharacters() throws Exception {
            //given

            //when

            //then
        }
        //todo: customer 잘못된 생성 : 성 혹은 이름에 숫자가 들어감
        @Test
        @DisplayName("생성 실패 : 성이나 이름이 숫자를 가지고 있음")
        public void failureWithNumbers() throws Exception {
            //given

            //when

            //then
        }
    }

    @Nested
    @DisplayName("When read")
    class WhenRead{
        //todo: customer를 ID 로 조회 성공

        //todo: customer를 ID 로 조회 실패

        // TODO: 2023-01-02 customers를 이름으로 조회 성공

        // TODO: 2023-01-02 customers를 이름으로 조회 실패

        // TODO: 2023-01-02 customers를 전체 조회

        // TODO: 2023-01-02 customers를 전체 조회 (no customers)
    }

    @Nested
    @DisplayName("When update")
    class WhenUpdate{
        //todo: customer 업데이트 성공

        //todo: customer 업데이트 실패 : 성 혹은 이름이 공백

        //todo: customer 업데이트 실패 : 성 혹은 이름이 제한된 길이를 넘김
        // TODO: 2023-01-02 업데이트 실패 : 성 혹은 이름에 특수 문자가 들어감
        // TODO: 2023-01-02 업데이트 실패 : 성 혹은 이름에 숫자가 들어감
    }

    @Nested
    @DisplayName("When delete")
    class WhenDelete{
        // TODO: 2023-01-02 id로 삭제 성공
        // TODO: 2023-01-02 id 로 삭제 실패 (없는 아이디)
    }
}
