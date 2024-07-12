CREATE TABLE _sqlx_migrations (
    version bigint NOT NULL,
    description text NOT NULL,
    installed_on timestamp with time zone DEFAULT now() NOT NULL,
    success boolean NOT NULL,
    checksum bytea NOT NULL,
    execution_time bigint NOT NULL
);

CREATE TABLE ad (
    id integer NOT NULL,
    creator_id integer NOT NULL,
    created_at bigint NOT NULL,
    image character varying(255),
    title character varying(255) NOT NULL,
    description text NOT NULL,
    subcategory_id integer,
    status_id integer DEFAULT 1 NOT NULL,
    status_changed_at bigint,
    featured boolean DEFAULT false NOT NULL,
    country character varying(255) NOT NULL,
    rejection_message character varying(255),
    featured_upd text[] DEFAULT '{}'::text[] NOT NULL,
    cta text
);

CREATE TABLE ad_category (
    id integer NOT NULL,
    name character varying(255) NOT NULL,
    name_ar character varying(255) NOT NULL
);

CREATE TABLE ad_likes (
    user_id integer NOT NULL,
    ad_id integer NOT NULL,
    created_at bigint NOT NULL
);

CREATE TABLE ad_rotation (
    country character varying(2) NOT NULL,
    ads integer[] DEFAULT '{}'::integer[] NOT NULL,
    last_updated bigint DEFAULT 0 NOT NULL
);

CREATE TABLE ad_status (
    id integer NOT NULL,
    name character varying(20) NOT NULL
);

CREATE TABLE ad_subcategory (
    id integer NOT NULL,
    name character varying(255) NOT NULL,
    category_id integer NOT NULL,
    name_ar character varying(255) NOT NULL
);

CREATE TABLE app_state (
    ad_submission_max integer DEFAULT 1 NOT NULL,
    home_btn_img_1 text,
    home_btn_img_2 text,
    home_btn_img_3 text,
    home_btn_img_4 text,
    wa_token text
);

CREATE TABLE bid (
    id integer NOT NULL,
    item_name text NOT NULL,
    item_description text,
    created_at bigint NOT NULL,
    stream_id text NOT NULL,
    user_id integer NOT NULL,
    order_id integer NOT NULL,
    price real DEFAULT 0.0 NOT NULL,
    screenshot character varying(255)
);

CREATE TABLE auction (
    id integer NOT NULL,
    name character varying(255) NOT NULL,
    description character varying(255) NOT NULL,
    created_at bigint NOT NULL,
    image_url character varying(255),
    country character varying(2),
    identifier text,
    owner_id integer,
    online_stream text,
    status character varying(255) DEFAULT 'ACTIVE'::character varying NOT NULL,
    story integer
);

CREATE TABLE auction_admin (
    auction_id integer NOT NULL,
    admin_id integer NOT NULL
);

CREATE TABLE auction_streamer (
    auction_id integer NOT NULL,
    streamer_id integer NOT NULL
);

CREATE TABLE client_errors (
    id integer NOT NULL,
    client_id integer,
    json text NOT NULL,
    since bigint DEFAULT (EXTRACT(epoch FROM now()) * (1000)::numeric),
    until bigint DEFAULT (EXTRACT(epoch FROM now()) * (1000)::numeric)
);

CREATE TABLE conversation (
    id integer NOT NULL,
    user_1_id integer NOT NULL,
    user_2_id integer NOT NULL,
    banned boolean DEFAULT false NOT NULL
);

CREATE TABLE events (
    id integer NOT NULL,
    endpoint text NOT NULL,
    user_id integer NOT NULL,
    table_ text NOT NULL,
    "timestamp" bigint NOT NULL,
    message text NOT NULL
);

CREATE TABLE location (
    user_id integer NOT NULL,
    id integer NOT NULL,
    is_primary boolean DEFAULT false NOT NULL,
    name text,
    created_at bigint NOT NULL,
    note text,
    latitude double precision NOT NULL,
    longitude double precision NOT NULL
);

CREATE TABLE message (
    id integer NOT NULL,
    message text NOT NULL,
    created_at bigint NOT NULL,
    read_at bigint,
    from_user_id integer NOT NULL,
    conversation_id integer NOT NULL
);

CREATE TABLE orders (
    user_id integer NOT NULL,
    stream_id text NOT NULL,
    created_at bigint NOT NULL,
    status character varying(255) NOT NULL,
    comment character varying(255),
    id integer NOT NULL,
    assigned_courier_id integer,
    location_id integer
);

CREATE TABLE permission (
    permission_id integer NOT NULL,
    permission_name character varying(255) NOT NULL
);

CREATE TABLE product (
    id integer NOT NULL,
    store_id integer NOT NULL,
    name text NOT NULL,
    subcategory integer NOT NULL,
    images text[] NOT NULL,
    description text NOT NULL,
    price integer NOT NULL,
    active boolean DEFAULT true NOT NULL,
    items_remaining integer DEFAULT 1 NOT NULL,
    deleted boolean DEFAULT false NOT NULL
);

CREATE TABLE session (
    session_id character varying(40) NOT NULL,
    user_agent character varying(255) NOT NULL,
    last_activity bigint NOT NULL,
    user_id integer NOT NULL
);

CREATE TABLE spent_tokens (
    token character varying(512) NOT NULL,
    created_at integer NOT NULL
);

CREATE TABLE store (
    id integer NOT NULL,
    name text NOT NULL,
    owner_id integer NOT NULL,
    images text[] NOT NULL,
    stream_minutes integer DEFAULT 0 NOT NULL,
    country text NOT NULL,
    currency text NOT NULL,
    story integer,
    created_at bigint DEFAULT 0 NOT NULL,
    updated_at bigint DEFAULT 0 NOT NULL,
    priority integer DEFAULT 0 NOT NULL,
    status text DEFAULT 'active'::text NOT NULL,
    next_live bigint
);

CREATE TABLE store_admin (
    store_id integer NOT NULL,
    user_id integer NOT NULL
);

CREATE TABLE store_auction_bid (
    id integer NOT NULL,
    auction_item_id integer NOT NULL,
    user_id integer NOT NULL,
    created_at bigint NOT NULL,
    amount real NOT NULL
);

CREATE TABLE store_auction_item (
    id integer NOT NULL,
    product_id integer NOT NULL,
    store_id integer NOT NULL,
    start_time bigint NOT NULL,
    end_time bigint NOT NULL,
    created_at bigint NOT NULL,
    starting_price real NOT NULL,
    increment real NOT NULL,
    auto_sell_at_price real
);

CREATE TABLE store_order (
    id integer NOT NULL,
    user_id integer NOT NULL,
    created_at bigint NOT NULL,
    status character varying(255) NOT NULL,
    comment character varying(255),
    location_id integer,
    store_id integer NOT NULL,
    assigned_courier_id integer
);

CREATE TABLE store_order_item (
    store_order_id integer NOT NULL,
    product_id integer NOT NULL,
    quantity integer DEFAULT 1 NOT NULL
);

CREATE TABLE store_rate (
    store_id integer NOT NULL,
    user_id integer NOT NULL,
    rating integer NOT NULL,
    comment text NOT NULL,
    updated_at bigint NOT NULL
);

CREATE TABLE store_stream (
    id integer NOT NULL,
    started bigint NOT NULL,
    ended bigint NOT NULL,
    title text NOT NULL,
    store_id integer NOT NULL
);

CREATE TABLE story (
    id integer NOT NULL,
    asset_url text NOT NULL,
    created_at bigint NOT NULL
);

CREATE TABLE stream (
    id character varying(12) NOT NULL,
    started bigint NOT NULL,
    ended bigint,
    title character varying(255) NOT NULL,
    views integer,
    auction_id integer,
    streamer_id integer NOT NULL,
    chat_port integer,
    description character varying(255) DEFAULT ''::character varying NOT NULL
);

CREATE TABLE support_category (
    id integer NOT NULL,
    name text NOT NULL,
    name_ar text NOT NULL
);

CREATE TABLE support_ticket (
    id integer NOT NULL,
    created_at bigint NOT NULL,
    creator_id integer,
    assignee_id integer,
    status text DEFAULT 'pending'::text NOT NULL,
    status_upd text[],
    priority text DEFAULT 'unprioritized'::text NOT NULL,
    category_id integer NOT NULL
);

CREATE TABLE support_ticket_comment (
    id integer NOT NULL,
    ticket_id integer,
    created_at bigint NOT NULL,
    creator_id integer,
    comment text NOT NULL
);

CREATE TABLE user_account (
    id integer NOT NULL,
    name text NOT NULL,
    surname text NOT NULL,
    phone bigint NOT NULL,
    email text NOT NULL,
    password text NOT NULL,
    role text NOT NULL,
    created_at bigint NOT NULL,
    updated_at bigint NOT NULL,
    image text,
    country character varying(2) NOT NULL,
    banned boolean DEFAULT false NOT NULL,
    push_token text,
    pw_reset_token character varying(255),
    verified boolean DEFAULT false NOT NULL,
    otp integer
);

CREATE TABLE user_auction (
    user_id integer NOT NULL,
    auction_id integer NOT NULL,
    banned boolean DEFAULT false NOT NULL
);

CREATE TABLE user_permission (
    user_id integer NOT NULL,
    permission_id integer NOT NULL
);

CREATE TABLE verified_phones (
    id integer NOT NULL,
    phone_number character varying(255) NOT NULL
);

