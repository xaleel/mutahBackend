package app.mutah.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum UserRole {
    @JsonProperty("superuser")
    SUPERUSER,
    @JsonProperty("support_admin")
    SUPPORT_ADMIN,
    @JsonProperty("auctioneer")
    AUCTIONEER,
    @JsonProperty("auction_streamer")
    AUCTION_STREAMER,
    @JsonProperty("auction_admin")
    AUCTION_ADMIN,
    @JsonProperty("store_owner")
    STORE_OWNER,
    @JsonProperty("store_admin")
    STORE_ADMIN,
    @JsonProperty("store_streamer")
    STORE_STREAMER,
    @JsonProperty("courier")
    COURIER,
    @JsonProperty("user")
    USER
}
