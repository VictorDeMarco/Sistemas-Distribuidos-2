import mysql.connector

def obtener_conexion():
    return mysql.connector.connect(
        host="localhost",
        port=3607,
        user="root",
        password="123456",
        database="libreria",
        ssl_disabled=True
    )

def inicializar_tabla_productos():
    conexion = obtener_conexion()
    cursor = conexion.cursor()

    cursor.execute("""
        CREATE TABLE IF NOT EXISTS productos (
            id INT AUTO_INCREMENT PRIMARY KEY,
            nombre VARCHAR(255) NOT NULL,
            precio DECIMAL(10, 2) NOT NULL
        )
    """)
    cursor.execute("SELECT COUNT(*) FROM productos")
    if cursor.fetchone()[0] == 0:
        cursor.execute("INSERT INTO productos (nombre, precio) VALUES ('Galletas', 1.99)")
        cursor.execute("INSERT INTO productos (nombre, precio) VALUES ('Cafe', 2.50)")
        cursor.execute("INSERT INTO productos (nombre, precio) VALUES ('Chocolate', 3.75)")
        cursor.execute("INSERT INTO productos (nombre, precio) VALUES ('Nestea', 3.20)")
        conexion.commit()

    cursor.close()
    conexion.close()

if __name__ == '__main__':
    inicializar_tabla_productos()
    print("Tabla productos creada e inicializada.")