package com.example.Homework3.HW3;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hw3")
@Tag(name = "Users", description = "Операции для управления пользователями")
public class HW3 {
    private final UserService userService;

    public HW3(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Получить имя пользователя", description = "Вернуть имя пользователя")
    @GetMapping("/username")
    public String getUsername() {
        return "Филипп";
    }


    @Operation(summary = "Получить пользователя по ID", description = "Вернуть информацию о пользователе")
    @GetMapping("/user/{id}")
    public User getUser(
            @Parameter(
                    description = "Уникальный идентификарот пользователя. Должен быть положительным числом",
                    example = "123",
                    required = true

            ) @PathVariable long id,

            @Parameter(
                    name = "details",
                    description = "Возвращает расширенную информацию о пользователе",
                    example = "true"
            )

            @RequestParam(defaultValue = "false") boolean details) {
        return userService.findById(id);
    }



    @Operation(summary = "Создать пользователя", description = "Создает нового пользователя с указанными данными")
    @PostMapping("/user")
    public User createUser(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                        description = "Объект пользоваьеля, который содержит имя, email и пароль",
                        required = true,
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = User.class),
                                examples = @ExampleObject(
                                        value = """
                                            {
                                              "name": "Иван",
                                              "email": "ivan@example.com",
                                              "password": "secret"
                                            } """
                                )
                    )
            )User user) {
        return userService.save(user);
    }


    @Operation(
            summary = "Получить список пользователей",
            description = "Возвращает список всех зарегистрированных пользователей"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Успешное получение списка пользователей",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(
                                    schema = @Schema(implementation = User.class)
                            )
                    )
            )
    })
    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.findAll();
    }


}
