package com.codearp.patterns.abstractfactories.b_insurrance.domains.types;

/**
 * Enumeration representing different types of identification entities.
 *
 * This can include various national and international identification documents.
 *
 * Each type corresponds to a specific format or standard used in different countries.
 *
 * For example:
 *
 * - NIE for foreign resident identification in Spain, SSN for Social Security Numbers in the USA,
 * - CIF for company tax identification in Spain, and OTHER for any other types not explicitly listed.
 * - SSN stands for Social Security Number, commonly used in the United States for individual identification.
 * - NIF stands for Número de Identificación Fiscal, which is used in Spain for tax purposes.
 * - PASSPORT refers to the travel document issued by a government to its citizens for international travel.
 * - OTHER serves as a catch-all category for identification types that do not fall under the predefined categories.
 *
 * This enumeration can be used in applications that require handling of personal identification information,
 *
 */
public enum IdentificationEntityType {
    PASSPORT,
    NIF,
    NIE,
    SSN,
    CIF,
    OTHER
}
