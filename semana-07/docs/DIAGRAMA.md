```mermaid
graph TD
    subgraph com.consultoria
        A[Main.java]
    end

    subgraph com.consultoria.servicio
        B(GestorConsultores.java)
    end

    subgraph com.consultoria.modelo
        C[Consultor]
        D[ConsultorSenior]
        E[ConsultorJunior]
    end

    subgraph com.consultoria.excepciones
        F(ContratoInvalidoException)
        G(CapacidadAgotadaException)
    end

    %% Relaciones de Uso (Dependencias)
    A --> B
    B --> C
    B --> F
    B --> G
    D --> C 
    E --> C