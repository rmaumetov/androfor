package com.azhimkulov.azamat.svetofor.entity.detailed;

import java.io.Serializable;

/**
 * Created by azamat  on 04.04.18.
 */

public class Detailed implements Serializable {
    private String object_id;
    private String object_type;
    private String image_path;
    private String alt;
    private String image_x;
    private String image_y;
    private String http_image_path;
    private String https_image_path;
    private String absolute_path;
    private String relative_path;

    public String getObject_id() {
        return object_id;
    }

    public void setObject_id(String object_id) {
        this.object_id = object_id;
    }

    public String getObject_type() {
        return object_type;
    }

    public void setObject_type(String object_type) {
        this.object_type = object_type;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getImage_x() {
        return image_x;
    }

    public void setImage_x(String image_x) {
        this.image_x = image_x;
    }

    public String getImage_y() {
        return image_y;
    }

    public void setImage_y(String image_y) {
        this.image_y = image_y;
    }

    public String getHttp_image_path() {
        return http_image_path;
    }

    public void setHttp_image_path(String http_image_path) {
        this.http_image_path = http_image_path;
    }

    public String getHttps_image_path() {
        return https_image_path;
    }

    public void setHttps_image_path(String https_image_path) {
        this.https_image_path = https_image_path;
    }

    public String getAbsolute_path() {
        return absolute_path;
    }

    public void setAbsolute_path(String absolute_path) {
        this.absolute_path = absolute_path;
    }

    public String getRelative_path() {
        return relative_path;
    }

    public void setRelative_path(String relative_path) {
        this.relative_path = relative_path;
    }
}
