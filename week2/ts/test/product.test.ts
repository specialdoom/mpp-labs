import { describe, it, expect } from "vitest";
import { Product } from "../src/model/product.model";

describe("Product", () => {
  describe("when calling default `constructor`", () => {
    it("should create an empty product", () => {
      const product = new Product();

      expect(product.getId()).toBe("");
      expect(product.description).toBe("");
      expect(product.price).toBe(0.0);
      expect(product.count).toBe(0);
    });
  });

  describe("when calling `constructor` with params", () => {
    it("should create a product with specified properties", () => {
        const product = new Product("1234","Description",2.56,5);

        expect(product.getId()).toBe("1234");
      expect(product.description).toBe("Description");
      expect(product.price).toBe(2.56);
      expect(product.count).toBe(5);
    })
  })
});
