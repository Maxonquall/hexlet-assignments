package exercise.controller;

import io.javalin.validation.ValidationException;
import org.apache.commons.lang3.StringUtils;
import exercise.util.Security;
import exercise.model.User;
import exercise.util.NamedRoutes;
import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.repository.UserRepository;
import exercise.dto.users.UserPage;
import io.javalin.http.NotFoundResponse;
import io.javalin.http.Context;

import java.util.Collections;


public class UsersController {

    public static void build(Context ctx) throws Exception {
        ctx.render("users/build.jte");
    }

    // BEGIN
    public static void create(Context ctx) {
        try {
            var firstName = ctx.formParam("firstName");
            var lastName = ctx.formParam("lastName");
            var email = ctx.formParam("email");
            var password = ctx.formParam("password");

            // Генерация токена и сохранение пользователя
            var token = Security.generateToken();
            var user = new User(firstName, lastName, email, password, token);
            UserRepository.save(user);
            var id = user.getId();
            // Редирект на страницу пользователя по его id
            ctx.redirect(NamedRoutes.userPath(id));
            ctx.cookie("token", token);
        } catch (ValidationException e) {
            // Обработка ошибок валидации, если необходимо
            ctx.status(422).render("users/build.jte");
        }
    }

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        if (UserRepository.find(id).isPresent()) {
            var user = UserRepository.find(id)
                    .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
            var token = user.getToken();
            var userToken = ctx.cookie("token");
            if (token.equals(userToken)) {
                ctx.render("users/show.jte", Collections.singletonMap("user", user));
            } else {
                throw new NotFoundResponse("User not found");
            }
        } else {
            ctx.redirect(NamedRoutes.buildUserPath());
        }
    }
    // END
}
