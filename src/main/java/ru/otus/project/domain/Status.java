package ru.otus.project.domain;

public enum Status {
    CREATED {
        public Status next() {
            return ASSEMBLY;
        }

        public Status prev() {
            return null;
        }
    },
    ASSEMBLY {
        public Status next() {
            return INSPECTION;
        }

        public Status prev() {
            return CREATED;
        }
    },
    INSPECTION {
        public Status next() {
            return SENT;
        }

        public Status prev() {
            return ASSEMBLY;
        }
    },
    SENT {
        public Status next() {
            return CLOSED;
        }

        public Status prev() {
            return INSPECTION;
        }
    },
    CLOSED {
        public Status next() {
            return null;
        }

        public Status prev() {
            return SENT;
        }
    },
    CANCELLED {
        public Status next() {
            return null;
        }

        public Status prev() {
            return null;
        }
    };

    public abstract Status next();
    public abstract Status prev();
    public Status cancel() {
        return CANCELLED;
    }
}
