package dev.mike.linktree.dev;


import dev.mike.linktree.model.Link;
import io.quarkus.runtime.LaunchMode;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.transaction.Transactional;


@ApplicationScoped
public class DevData {

    @Transactional
    void onStart(@Observes StartupEvent ev) {
        LaunchMode mode = LaunchMode.current();
            if (mode  != LaunchMode.DEVELOPMENT) {
                return;
            }
            if (Link.count() > 0) {
                return;
            }

            seedLink("GitHub", "https://github.com/mike280203/quarkus-linktree", "Projektverzeichnis in GitHub", "fa-brands fa-github", 0);
            seedLink("Instagram", "https://instagram.com/mxke28_", "Mein Instagram", "fa-brands fa-instagram", 1);
            seedLink("X", "https://x.com/mxkehimself", "Mein X", "fa-brands fa-x-twitter", 2);
    }

    private void seedLink(String title, String url, String description, String icon, int sortOrder) {
        Link link = new Link();
        link.title = title;
        link.url = url;
        link.description = description;
        link.icon = icon;
        link.sortOrder = sortOrder;
        link.active = true;
        link.persist();
    }



}