declare module "java-js-dateformat" {
  export const Formatters: {
    formatLocalDate(
      year: number,
      month: number,
      day: number,
      pattern: string,
      locale?: string
    ): string;
    formatInstant(
      epochMS: string,
      pattern: string,
      locale?: string,
      zone?: string
    ): string;
  };
}
