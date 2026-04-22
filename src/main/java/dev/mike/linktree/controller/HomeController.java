package dev.mike.linktree.controller;

import java.util.List;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import io.quarkiverse.renarde.Controller;
import dev.mike.linktree.model.Link;
import jakarta.ws.rs.Path;

/**
 * Public page controller for the Linktree homepage.
 *
 * - Extends Renarde's {@link Controller} base class.
 * - Handles HTTP requests and returns Qute templates.
 */
public class HomeController extends Controller {

    /**
     * - {@link CheckedTemplate} verifies the referenced template at build time.
     * - The method name maps to `templates/HomeController/index.html`.
     * - The method parameters become variables inside the template.
     */
    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance index(List<Link> links);
    }

    /**
     * Renders the public homepage at `/`.
     *
     * @return a Qute template instance, not JSON or a plain string
     */
    @Path("/")
    public TemplateInstance index() {
        List<Link> links = Link.findActiveOrdered();
        return Templates.index(links);
    }
}

