package amazon.utility;

import java.io.File;
import net.rcarz.jiraclient.BasicCredentials;
import net.rcarz.jiraclient.Field;
import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.JiraClient;
import net.rcarz.jiraclient.JiraException;
import net.rcarz.jiraclient.Issue.FluentCreate;

/**
 * 
 * This is my code to connect with JIRA account and log a bug It also attaches
 * the image to the failed test case along with bug title
 *
 */

public class JiraPlugIn {

	public JiraClient jira;
	public String project;

	public JiraPlugIn(String jiraURL, String userName, String pwd, String project) {

		BasicCredentials creds = new BasicCredentials(userName, pwd);
		jira = new JiraClient(jiraURL, creds);
		this.project = project;
	}

	public void createJiraTicket(String issueType, String Summary, String desc, File attachment, String reporterName) {
		try {
			FluentCreate fluentCreate = jira.createIssue(project, issueType);
			fluentCreate.field(Field.SUMMARY, Summary);
			fluentCreate.field(Field.DESCRIPTION, desc);
			Issue newIssue = fluentCreate.execute();
			System.out.println("New issue created in jira with ID" + newIssue);
			newIssue.addAttachment(attachment);
		} catch (JiraException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
