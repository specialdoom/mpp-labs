const Database = require('better-sqlite3');

class DbUtils {
    #properties;

    #connection;

    constructor(properties) {
        this.#properties = properties;
    }

    #getNewConnection() {
        const url = this.#properties.url;

        let connection = null;

        try {
            connection = new Database(url, { verbose: console.log });
        } catch (e) {
            console.error("Creating connection failed!", e);
        }

        return connection;
    }

    getConnection() {
        try {
            if (!this.#connection) {
                this.#connection = this.#getNewConnection();
            }
        } catch (e) {
            console.error("Database unreachable", e);
        }

        return this.#connection;
    }
}

module.exports = DbUtils;