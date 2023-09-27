package utils;

public class Endpoints {
    public static final String GET_ALL_PROJECTS = "/api/v1/projects";
    public static final String GET_PROJECT = "/api/v1/projects/";
    public static final String GET_ALL_USERS = "/api/v1/users";
    public static final String POST_ADD_RUN = "/api/v1/projects/{project_id}/automation/runs";
    public static final String GET_RUN = "/api/v1/runs/{run_id}";
    public static final String GET_MILESTONES = "/api/v1/projects/{project_id}/milestones?page={number_page}";
}