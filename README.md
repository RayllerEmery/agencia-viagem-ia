# module-ia-quarkus

Mono-repo containing two Quarkus microservices that together form an AI-powered travel booking system.

## Projects

### agencia-viagem-ia (port 8080)
AI travel agent built with Quarkus + LangChain4j + Ollama.  
Features RAG (Retrieval-Augmented Generation), guardrails (prompt injection, tone, JSON structure), and chat memory.  
Consumes booking tools from `mcp-booking-server` via the MCP protocol.

- Java 21 / Quarkus 3.34.6
- LangChain4j, Ollama, PGVector

### mcp-booking-server (port 8081)
MCP (Model Context Protocol) server that exposes booking tools over HTTP/SSE.  
Provides booking creation, status tracking, and category management.

- Java 25 / Quarkus 3.27.3.1
- Quarkus MCP Server SSE

## Architecture

```
[ agencia-viagem-ia :8080 ]  --MCP/SSE-->  [ mcp-booking-server :8081 ]
          |
     [ Ollama LLM ]
          |
     [ PGVector DB ]
```

## Running locally

Start the booking server first:
```bash
cd mcp-booking-server
./mvnw quarkus:dev
```

Then start the travel agent:
```bash
cd agencia-viagem-ia
./mvnw quarkus:dev
```
