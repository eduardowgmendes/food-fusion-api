package br.com.edu.foodfusion.shared.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DefaultResponse<T> {

    private Boolean success;
    private String message;
    private T body;

    public static <T> DefaultResponse<T> create(boolean isSuccess, String message, T body) {
        return new DefaultResponse<>(isSuccess, message, body);
    }

    public static <T> DefaultResponse<T> fail(String message) {
        return new DefaultResponse<>(false, message, null);
    }

    public static <T> DefaultResponse<T> success(String message, T body) {
        return new DefaultResponse<>(true, message, body);
    }
}
