package main

import (
	"fmt"
	"net/http"
	"os"

	"github.com/prometheus/client_golang/prometheus"
	"github.com/prometheus/client_golang/promhttp"
)

func main() {
	// Create a new Counter metric
	counter := prometheus.NewCounter(prometheus.CounterOpts{
		Name: "example_counter",
		Help: "A simple example counter",
	})

	// Register the metric with the Prometheus default registry
	prometheus.MustRegister(counter)

	// Increment the counter in response to a request
	http.HandleFunc("/", func(w http.ResponseWriter, r *http.Request) {
		counter.Inc()
		fmt.Fprintf(w, "Hello, Prometheus!\n")
	})

	// Expose the metrics on /metrics
	http.Handle("/metrics", promhttp.Handler())

	// Start the HTTP server
	port := "8080"
	if envPort := os.Getenv("PORT"); envPort != "" {
		port = envPort
	}

	fmt.Printf("Listening on :%s\n", port)
	err := http.ListenAndServe(":"+port, nil)
	if err != nil {
		fmt.Printf("Error: %s\n", err)
	}
}
