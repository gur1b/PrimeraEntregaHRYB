
DROP TABLE IF EXISTS DETALLE_FACTURA;

DROP TABLE IF EXISTS Factura;

DROP TABLE IF EXISTS Producto;

DROP TABLE IF EXISTS Cliente;

CREATE TABLE Cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    numeroDNI VARCHAR(20) UNIQUE NOT NULL
);

CREATE TABLE Producto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    codigo VARCHAR(50) UNIQUE NOT NULL,
    descripcion VARCHAR(255) NOT NULL,
    stock INT NOT NULL CHECK (stock >= 0),
    precio DECIMAL(10,2) NOT NULL CHECK (precio >= 0)
);

CREATE TABLE Factura (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT NOT NULL,
    fecha_Creacion DATETIME DEFAULT CURRENT_TIMESTAMP,
    total DECIMAL(10,2) NOT NULL CHECK (total >= 0),
    FOREIGN KEY (id_cliente) REFERENCES Cliente(id) ON DELETE CASCADE
);

CREATE TABLE DETALLE_FACTURA (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_factura INT NOT NULL,
    producto_id INT NOT NULL,
    monto INT NOT NULL CHECK (monto > 0),
    precio DECIMAL(10,2) NOT NULL CHECK (precio >= 0),
    FOREIGN KEY (id_factura) REFERENCES Factura(id) ON DELETE CASCADE,
    FOREIGN KEY (producto_id) REFERENCES Producto(id) ON DELETE CASCADE
);
