FROM grafana/grafana:6.0.2

WORKDIR /var/lib/grafana/plugins

RUN grafana-cli plugins install grafana-kubernetes-app

WORKDIR /

ENTRYPOINT [ "/run.sh" ]
