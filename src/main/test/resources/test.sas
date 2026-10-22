🍌
Prueba de verificación rápida en Comix (.cmx / .sas)
🍌
arquitectura TestRapido :
    sinapsis indice iteracion <- 1
    sinapsis peso tasa <- 0.01
    sinapsis tensor pesos <- [0.1, 0.2]
    sinapsis pulso estado <- activo

    entrenar converger 🐒iteracion <= 5 && 🐒tasa > 0.001🐵🐵 :
        ajustar tasa <- tasa * 0.95
        ajustar iteracion <- iteracion + 1
    ;

    evaluar tasa >= 0.005
    activar :
        proyectar "Tasa estable:", tasa
    ;
    recalibrar tasa >= 0.002 :
        proyectar "Tasa baja:", tasa
    ;
    descartar :
        proyectar "Tasa crítica:", tasa
    ;
;
