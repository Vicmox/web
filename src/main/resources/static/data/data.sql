-- Crear tabla de empleados
CREATE TABLE empleado (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    fecha_nacimiento DATE,
    departamento VARCHAR(50)
);

-- Insertar datos de empleados de prueba
INSERT INTO empleado (nombre, email, fecha_nacimiento, departamento)
VALUES ('Juan Pérez', 'juan@example.com', '1990-01-15', 'Ventas');

INSERT INTO empleado (nombre, email, fecha_nacimiento, departamento)
VALUES ('María Gómez', 'maria@example.com', '1985-05-20', 'Marketing');
