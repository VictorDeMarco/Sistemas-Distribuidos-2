import requests
from flask import Flask, jsonify
from db import obtener_conexion

app = Flask(__name__)

@app.route('/api/ok')
def api_ok():
    return jsonify({"mensaje": "Todo esta funcionando correctamente"})

# Ruta que simula error de archivo
@app.route('/api/file-error')
def file_error():
    try:
        with open("no_existe.txt", "r") as f:
            f.read()
    except FileNotFoundError as e:
        return jsonify({"error": "Archivo no encontrado", "excepcion": "400 BAD REQUEST" ,"detalle": str(e)}), 400

@app.route('/api/db-error')
def db_error():
    try:
        conexion = obtener_conexion()
        cursor = conexion.cursor()
        cursor.execute("SELECT * FROM tabla_que_no_existe")
    except Exception as e:
        return jsonify({"error": "Error en la base de datos compartida", "excepcion":"500 INTERNAL SERVER ERROR","detalle": str(e)}), 500

@app.route('/api/productos')
def obtener_productos():
    try:
        conexion = obtener_conexion()
        cursor = conexion.cursor()
        cursor.execute("SELECT * FROM productos")
        productos = cursor.fetchall()
        return jsonify({"productos": productos})
    except Exception as e:
        return jsonify({"error": "Error de acceso a productos", "detalle": str(e)}), 500

@app.route('/api/external-error')
def external_api_error():
    try:
        response = requests.get("https://pokeapi.co/api/v2/pokemon/noexiste123")
        response.raise_for_status()
        return jsonify(response.json())
    except requests.RequestException as e:
        return jsonify({"error": "Error al llamar a la API externa", "excepcion": "502 BAD GATEWAY","detalle": str(e)}), 502

if __name__ == '__main__':
    app.run(debug=True)