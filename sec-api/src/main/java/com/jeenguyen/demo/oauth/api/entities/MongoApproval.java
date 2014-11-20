package com.jeenguyen.demo.oauth.api.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.oauth2.provider.approval.Approval;

/**
 * Created by jeebb on 12/11/2014.
 */
@Document(collection = "oauthApprovals")
public class MongoApproval {

    public static final String EXPIRE_AT = "expireAt";
    public static final String STATUS = "status";
    public static final String LAST_MODIFIED_AT = "lastModifiedAt";
    public static final String USER_ID = "userId";
    public static final String CLIENT_ID = "clientId";
    public static final String SCOPE = "scope";

    @Id
    private String id;

    private Long expireAt;
    private Approval.ApprovalStatus status;
    private Long lastModifiedAt;
    private String userId;
    private String clientId;
    private String scope;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(Long expireAt) {
        this.expireAt = expireAt;
    }

    public Approval.ApprovalStatus getStatus() {
        return status;
    }

    public void setStatus(Approval.ApprovalStatus status) {
        this.status = status;
    }

    public Long getLastModifiedAt() {
        return lastModifiedAt;
    }

    public void setLastModifiedAt(Long lastModifiedAt) {
        this.lastModifiedAt = lastModifiedAt;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
