package ru.geekbrains.server.auth;

import java.util.Set;

public class AuthenticationService {
    private static final Set<AuthEntry> entries = Set.of(
            new AuthEntry(0,"l1", "p1", "Nickname1"),
            new AuthEntry(1,"l2", "p2", "Nickname2"),
            new AuthEntry(2,"l3", "p3", "Nickname3")
    );

    public AuthEntry findUserByCredentials(String login, String password) {
        for (AuthEntry entry : entries) {
            if (entry.getLogin().equals(login) && entry.getPassword().equals(password)) {
                return entry;
            }
        }
        return null;
    }
}
