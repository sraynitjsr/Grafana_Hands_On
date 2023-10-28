# Grafana_Hands_On
Hands On Practice of Grafana Dashboard for System Metrics 


# Grafana Installation
### helm repo add nginx-stable https://helm.nginx.com/stable
### helm repo update
### helm install controller  nginx-stable/nginx-ingress --set prometheus.create=true --set prometheus.port=9901
### helm install prometheus stable/prometheus
### helm install grafana stable/grafana
