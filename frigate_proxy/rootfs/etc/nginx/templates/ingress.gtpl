server {
    listen 8080 default_server;

    include /etc/nginx/includes/server_params.conf;

    location / {
        allow   172.30.32.2;
        allow   192.168.50.22;
        deny    all;

        proxy_pass http://backend;
        proxy_set_header X-Ingress-Path {{ .entry }};
        include /etc/nginx/includes/proxy_params.conf;
    }
}