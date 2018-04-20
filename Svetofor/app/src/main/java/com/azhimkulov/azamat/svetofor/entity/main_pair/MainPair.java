package com.azhimkulov.azamat.svetofor.entity.main_pair;

import com.azhimkulov.azamat.svetofor.entity.detailed.Detailed;

import java.io.Serializable;

/**
 * Created by azamat  on 04.04.18.
 */

public class MainPair implements Serializable {
    private String pair_id;
    private String image_id;
    private String detailed_id;
    private String position;
    private Detailed detailed;

    public String getPair_id() {
        return pair_id;
    }

    public void setPair_id(String pair_id) {
        this.pair_id = pair_id;
    }

    public String getImage_id() {
        return image_id;
    }

    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }

    public String getDetailed_id() {
        return detailed_id;
    }

    public void setDetailed_id(String detailed_id) {
        this.detailed_id = detailed_id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Detailed getDetailed() {
        return detailed;
    }

    public void setDetailed(Detailed detailed) {
        this.detailed = detailed;
    }
}
