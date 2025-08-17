package com.feedbackfusion.app;

import com.feedbackfusion.presentation.FeedbackForm;
import com.feedbackfusion.service.FeedbackService;

/**
 * Entry point of the FeedbackFusion application.
 * 
 * <p>This class is responsible for bootstrapping the application. 
 * It initializes the required service layer and passes it to 
 * the presentation layer (FeedbackForm).
 * 
 * <p>Responsibilities:
 * <ul>
 *   <li>Acts as the composition root (central wiring point).</li>
 *   <li>Creates an instance of {@link FeedbackService} for business logic.</li>
 *   <li>Initializes the {@link FeedbackForm} which handles the user interface.</li>
 * </ul>
 */
public class Main {

    /**
     * The main method — starting point of the Java application.
     *
     * @param args command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        // Initialize the service layer (handles business logic & DB operations)
        FeedbackService service = new FeedbackService();

        // Pass the service to the UI layer (form for collecting feedback)
        new FeedbackForm(service);
    }
}
