package org.kj6682.frigo;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * This is the JPA repository for managing Hops.
 *
 * The Frigo microservice is bound to MongoDb in order to keep thing as simple as possible.
 * In case a different base should be needed, we will provide a specific version of the service
 *
 */
interface FrigoRepository extends MongoRepository<Frigo, String> {
}